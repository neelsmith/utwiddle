# `utwiddle` summary/cheat sheet

- URNs (fully implemented)
- OHCO2 Corpus (partially implemented)
- OrcaCollection of alignments  (partially implemented)
- Cite2Collection of objects
- CiteGraph of relations

## URNs (`CtsUrn` and `Cite2URN`)

| Status | Operator/function | Meaning  |
| :----- | :---------------- | :------- |
| √      | `URN == URN`      | equality |
| √      | `URN ~~ URN`      | matching |


### CtsUrns only


| Status | Operator/function       | Meaning                                                |
| :----- | :---------------------- | :----------------------------------------------------- |
|        | `CtsUrn collapseTo Int` | reduce passage component to specified level            |
|        | `CtsUrn collapseBy Int` | reduce passage component by specified number of levels |




## Collections (`Corpus` and `OrcaCollection`)


| Status                   | Operator/function           | Meaning                                                                     |
| :----------------------- | :-------------------------- | :-------------------------------------------------------------------------- |
| √ | `Collection.size`           | number of elements in collection                                            |
| √ | `Collection.urns`           | vector of identifying URNs                                                  |
| √                        | `Collection ++ Collection`  | addition    (*not* commutative!)                                            |
| √                        | `Collection -- Collection`  | subtraction                                                                 |
| √                        | `Collection ~~ URN`         | filter by URN (NB: chaining filters ~ boolean AND)                          |
| √                        | `Collection ~~ Vector[URN]` | filter for *any* of URNs in vector (~ boolean OR)                           |
|                          | `Collection.collapseTo Int` | remap collection to an ordered Map of Vectors keyed by the collapsed CtsUrn |
|                          | `Collection.collapseBy Int` | remap collection to an ordered Map of Vectors keyed by the collapsed CtsUrn |



### OrcaCollection only


| Status | Operator/function              | Meaning                                             |
| ------ | :----------------------------- | :-------------------------------------------------- |
|   √     | `OrcaCollection.analyses`      | vector of analysis Cite2Urns                        |
|    √    | `OrcaCollection.texts`         | vector of CtsUrns of analyzed passages              |
|    √    | `OrcaCollection.corpus String` | creates an analytical Corpus with given exemplar ID |
|        | `OrcaCollection ~~ Corpus`    |   filters by  text passages in a corpus|



### Corpus only


| Status | Operator/function | Meaning |
| ------ | :---------------- | :------ |
|        | `Corpus ~~ OrcaCollection`    |   filters by  text passages analyzed in OrcaCollection|
|    √    | `Corpus.texts`    |   vector of String values      |
