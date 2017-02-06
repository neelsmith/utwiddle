import edu.holycross.shot.greek._


println("\n\nCreate a Greek string using ascii notation:")
println("\tval s1 = LiteraryGreekString(\"mh=nin\")")
val s1 = LiteraryGreekString("mh=nin")
println("\ts1.ascii == " + s1.ascii)
println("\ts1.ucode == " + s1.ucode)

println("\n\nCreate a Greek string using unicode greek:")
println("\tval s2 = LiteraryGreekString(\"μῆνιν\")")
val s2 = LiteraryGreekString("μῆνιν")
println("\ts2.ascii == " + s2.ascii)
println("\ts2.ucode == " + s2.ucode)

println("\n\nCompare them:")
println("\ts1.ascii == s2.ascii ? " + (s1.ascii == s2.ascii))
println("\ts1.ucode == s2.ucode ? " + (s1.ucode == s2.ucode))