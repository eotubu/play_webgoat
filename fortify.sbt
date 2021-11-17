// this makes it so sbt can resolve the plugin
credentials += Credentials(
  Path.userHome / ".lightbend" / "commercial.credentials")
resolvers in ThisBuild += "lightbend-commercial-mvn" at
        "https://repo.lightbend.com/pass/vl7AdKjSDw92eira7Zx-_4NhYAYl9osIRa5ifmfX5kNiF_vJ/commercial-releases"
resolvers in ThisBuild += Resolver.url("lightbend-commercial-ivy",
        url("https://repo.lightbend.com/pass/vl7AdKjSDw92eira7Zx-_4NhYAYl9osIRa5ifmfX5kNiF_vJ/commercial-releases"))(Resolver.ivyStylePatterns)

// enable the plugin
addCompilerPlugin(
  "com.lightbend" %% "scala-fortify" % "1.0.13"
    classifier "assembly" cross CrossVersion.patch)

// configure the plugin
scalacOptions += "-P:fortify:build=play-webgoat"
                
