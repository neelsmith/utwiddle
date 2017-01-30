
println("Demo material to be added here from examples in the individually included code libraries.")
println("Teaser: try the `twiddle` demo")

def twiddle = {

  import edu.holycross.shot.cite._
  val iliad = CtsUrn("urn:cts:greekLit:tlg0012.tlg001:")
  val venetusA = CtsUrn("urn:cts:greekLit:tlg0012.tlg001.msA:")
  println("The Iliad = ")
  println("\t" + iliad)
  println("The Venetus A MS of the Iliad = ")
  println("\t" + venetusA)
  println("Do they match?")
  println("\tvenetusA ~~ iliad == " + (venetusA ~~ iliad) )

}
