# Working with a citable corpus of texts

You can try any of the things suggested here from a `sbt console` session in this directory.  The commands commented on here are copied from the script `corpus.sc`.  You run it from a console session with `:load corpus.sc`.

## Create a `Corpus` from a text file.

First import the libraries:

    import edu.holycross.shot.cite._
    import edu.holycross.shot.ohco2._

Then create a corpus from a two-column file.  In these examples, we'll use a corpus with more than a million words of Greek, Latin and English.


    val srcData = "resources/million.tsv"
    val corpus = CorpusSource.fromFile(srcData)


## Composable functions

The `Corpus` class includes a number of functions that take some input and create a new `Corpus`.  These can be chained together to compose a corpus on quite complex criteria.


### URN similarity: `~~`

URN at notional work level filters out all versions of Herodotus:

    val herodotus = corpus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:")

Verify that there is both a Greek text and an English translation by examing the URNs for the set of (two) distinct works in our new `herodotus` corpus:

    val citedWorks = herodotus.citedWorks


### Corpus union and difference: `++` and `--`

Create a corpus comprising two books of Herodotus, but note that you will have both English and Greek for these selections:

    val hdt1 = herodotus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:1")
    val hdt9 = herodotus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:9")
    val hdt1and9 = hdt1 ++ hdt9

Omit the first four chapters of book 9:

    val hdt1and9selection = hdt1and9 -- (hdt1and9 ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:9.1-9.4"))

Note that we sliced off four chapters in each of the two versions:

    assert(hdt1and9selection.size == hdt1and9.size - (4*2))

###  String searching functions: `find`

Create a corpus of all nodes containing the string "Herodotus":

    val hdtHimself = hdt1and9selection.find("Herodotus")

There's only one node (the proem, in English translation):

    assert (hdtHimself.size == 1)

Create a corpus with all nodes containing both the string "Persians" and the string "Medes" :

    val persiansAndMedes = Vector("Persians", "Medes")
    val persiansAndMedesText = herodotus.find(persiansAndMedes)

This happens a lot:

    assert (persiansAndMedesText.size == 46)

###  Searching for white-space delimited tokens: `findToken`, `findTokens`, `findTokensWithin`

    val oneHellene = herodotus.findToken("Hellene")
    val hellenes = herodotus.findToken("Hellenes")
    val allHellenes = oneHellene ++ hellenes
    assert(allHellenes.size == 367)

    val persiansAndMedesTokensText = herodotus.findTokens(persiansAndMedes)

    val proemStatement = herodotus.findTokensWithin(Vector("Showing","Herodotus", "forth"),10)

    assert(proemStatement.size == 1)

    val notCloseEnough = herodotus.findTokensWithin(Vector("Showing","Herodotus", "forth"), 5)
    assert (notCloseEnough.isEmpty)


## Non-composable functions


### Find frequency of n-grams

To make sense of n-grams, let's first select out the English translation of Herodotus, then find 4-grams that occur more than 10 times, omitting punctuation:

    val eng = herodotus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001.eng:")
    val fourGram = eng.ngramHisto(4,10,true)

The most common four-gram?

    assert (fourGram.histogram(0).text == "at the same time")
    assert (fourGram.histogram(0).count == 74)

### Plot histograms

Plot a histogram of the top 20 items in `fourGram`:

     WispDriver.bar(fourGram,20)


>**Warning**: this may freeze your console;  I don't know why or under what circumstances.  Use it when you're willing to shut down your console. :-(
