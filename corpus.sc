import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._

// demo corpus
val srcData = "resources/million.tsv"
val corpus = CorpusSource.fromFile(srcData)

// Things you can do with a Corpus that create another corpus:
//
// Corpus similarity with URN twiddling


val herodotus = corpus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:")
val citedWorks = herodotus.citedWorks
val hdt1 = herodotus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:1")
val hdt9 = herodotus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:9")

// Corpus union and difference:

val hdt1and9 = hdt1 ++ hdt9
val hdt1and9selection = hdt1and9 -- (hdt1and9 ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001:9.1-9.4"))
assert(hdt1and9selection.size == hdt1and9.size - (4*2))

// search for a String
val hdtHimself = hdt1and9selection.find("Herodotus")
assert (hdtHimself.size == 1)
// search for a vector of strings

val persiansAndMedes = Vector("Persians", "Medes")
val persiansAndMedesText = herodotus.find(persiansAndMedes)
assert (persiansAndMedesText.size == 46)



// search for a token
val oneHellene = herodotus.findToken("Hellene")
val hellenes = herodotus.findToken("Hellenes")
val allHellenes = oneHellene ++ hellenes
assert(allHellenes.size == 367)

// search for a vector of tokens

val persiansAndMedesTokensText = herodotus.findTokens(persiansAndMedes)


//search for a vector of tokens with a given distance


val proemStatement = herodotus.findTokensWithin(Vector("Showing","Herodotus", "forth"),10)

assert(proemStatement.size == 1)

val notCloseEnough = herodotus.findTokensWithin(Vector("Showing","Herodotus", "forth"), 5)
assert (notCloseEnough.isEmpty)



//find frequency of histograms

val eng = herodotus ~~ CtsUrn("urn:cts:greekLit:tlg0016.tlg001.eng:")
val fourGram = eng.ngramHisto(4,10,true)
assert (fourGram.histogram(0).text == "at the same time")
assert (fourGram.histogram(0).count == 74)

//- plot histograms
WispDriver.bar(fourGram,20)
