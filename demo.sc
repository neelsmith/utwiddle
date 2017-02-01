import edu.holycross.shot.cite._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.orca._


val demos =  Vector("urns", "texts", "alignments", "all")

println("\nA few simple demos.")
println("Try running any of the following:")
println (demos.map(s => "\t" + s).mkString("\n"))
println("")

def urns = {
  val iliad = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:")
  val venetusA = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:")
  println("The Iliad = ")
  println("\t" + iliad)
  println("The Venetus A MS of the Iliad = ")
  println("\t" + venetusA)
  println("Do they match?")
  println("\tvenetusA ~~ iliad == " + (venetusA ~~ iliad) )
  println("\n")
}


def texts = {

}

def alignments = {
  val orcaRaw = OrcaCollection(clauses)
  println("Start from " + orcaRaw.alignments.size + " analyses of grammatial clauses.")
  val expanded = orcaRaw.expandUrns(ilreff)
  println("Expand range URNs to yield  " + expanded.size + " analyses.")
  val orca = OrcaCollection(expanded)
  val indicative = Cite2Urn("urn:cite2:hmt:iliadicClauses.v1:indicative")
  val indicativeAnalyses = orca.urnMatch(indicative)
  println("Select indicative principal clauses: " + indicativeAnalyses.alignments.size + " analyses.")
}


def all = {
  println  ("-----------URN demo --------------------")
  urns
  println  ("-----------Text demo -------------------")
  texts
  println  ("-----------Alignment demo --------------")
  alignments
}


val clauses = """ORCA_URN	AnalyzedText	Analysis	textDeformation
urn:cite2:hmt:clausereading.v1:clause1	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.1-1.2@ν[2]	urn:cite2:hmt:iliadicClauses.v1:imperative	Μῆνιν ἄειδε θεὰ Πηληϊάδεω Ἀχιλῆος οὐλομένην
urn:cite2:hmt:clausereading.v1:clause2	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.2@ἣ[1]-1.2@ε[2]	urn:cite2:hmt:iliadicClauses.v1:indicative	ἣ μυρί᾽ Ἀχαιοῖς ἄλγε᾽ ἔθηκε
urn:cite2:hmt:clausereading.v1:clause3	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.3@π[1]-1.4@ν[1]	urn:cite2:hmt:iliadicClauses.v1:indicative	πολλὰς δ᾽ ἰφθίμους ψυχὰς Ἄϊδι προΐαψεν ἡρώων
urn:cite2:hmt:clausereading.v1:clause4	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.4@α[1]-1.5@ι[1]	urn:cite2:hmt:iliadicClauses.v1:indicative	αὐτοὺς δὲ ἑλώρια τεῦχε κύνεσσιν οἰωνοῖσί τε πᾶσ
urn:cite2:hmt:clausereading.v1:clause5	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.5@Δ[1]-1.5@ή[1]	urn:cite2:hmt:iliadicClauses.v1:indicative	Διὸς δ᾽ ἐτελείετο βουλή
urn:cite2:hmt:clausereading.v1:clause6	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.6-1.7	urn:cite2:hmt:iliadicClauses.v1:subordinate	ἐξ οὗ δὴ τὰ πρῶτα διαστήτην ἐρίσαντε Ἀτρεΐδης τε ἄναξ ἀνδρῶν καὶ δῖος Ἀχιλλεύς.§§f
urn:cite2:hmt:clauseclausereading.v1:clause7	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.8	urn:cite2:hmt:iliadicClauses.v1:interrogative	Τίς τάρ σφωε θεῶν ἔριδι ξυνέηκε μάχεσθαι;
urn:cite2:hmt:clausereading.v1:clause8	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.9@Λ[1]-1.9@ς[3]	urn:cite2:hmt:iliadicClauses.v1:indicative	Λητοῦς καὶ Διὸς υἱός [ξυνέηκε]
urn:cite2:hmt:clausereading.v1:clause9	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.9@ὃ[1]-1.10@ν[5]	urn:cite2:hmt:iliadicClauses.v1:indicative	ὃ γὰρ βασιλῆϊ χολωθεὶς νοῦσον ἀνὰ στρατὸν ὄρσε κακήν
urn:cite2:hmt:clausereading.v1:clause10	urn:cts:greekLit:tlg0012.tlg001.fuPers:1.10@ὀ[1]-1.10@ί[1]	urn:cite2:hmt:iliadicClauses.v1:indicative	ὀλέκοντο δὲ λαοί
urn:cite2:hmt:clausereading.v1:clause11	urn:cts:greekLit:tlg0012.tlg001.fuPers:2.1@οὐδέ[1]-2.1@ἐΐσης[1]	urn:cite2:hmt:iliadicClauses.v1:indicative	οὐδέ τι θυμὸς ἐδεύετο δαιτὸς ἐΐσης
"""



val ilreff = Vector(
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.1"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.2"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.3"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.4"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.5"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.6"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.7"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.8"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.9"),
  CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.10"),

CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.600"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.601"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.602"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.603"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.604"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.605"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.606"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.607"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.608"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.609"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.610"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:1.611"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.1"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.2"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.3"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.4"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.5"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.6"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.7"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.8"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.9"),
CtsUrn("urn:cts:greekLit:tlg0012.tlg001.fuPers:2.10")
)
