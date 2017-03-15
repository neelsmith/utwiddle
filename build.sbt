

resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith", "maven")

libraryDependencies ++=   Seq(
  "edu.holycross.shot.cite" %% "xcite" % "2.2.1",
  "edu.holycross.shot" %% "ohco2" % "6.11.0",
  "edu.holycross.shot" %% "orca" % "3.0.0"
)
