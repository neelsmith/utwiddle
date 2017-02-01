
scalaVersion := "2.12.1"

resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith", "maven")

libraryDependencies ++=   Seq(
  "edu.holycross.shot.cite" %% "xcite" % "1.2.0",
  "edu.holycross.shot" %% "ohco2" % "3.0.0"
)
