package(default_visibility = ["//visibility:public"])

java_import(name = "lib/bootstrap",           jars = ["lib/bootstrap.jar"],           srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/extensions",          jars = ["lib/extensions.jar"],          srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/java-api",            jars = ["lib/java-api.jar"],            srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/java-impl",           jars = ["lib/java-impl.jar"],           srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/jdom",                jars = ["lib/jdom.jar"],                srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/jna",                 jars = ["lib/jna.jar"],                 srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/log4j",               jars = ["lib/log4j.jar"],               srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/openapi",             jars = ["lib/openapi.jar"],             srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/platform-api",        jars = ["lib/platform-api.jar"],        srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/platform-impl",       jars = ["lib/platform-impl.jar"],       srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/trove4j",             jars = ["lib/trove4j.jar"],             srcjar = "@idea-IC-sources//jar")
java_import(name = "lib/util",                jars = ["lib/util.jar"],                srcjar = "@idea-IC-sources//jar")
# TODO having issues with dependening on classes in this jar; two classloaders are loading the same classes and causing an error.
# We should use neverlink = True, but then we actually need to create the class in our project else we won't find it.
java_import(name = "plugins/maven/lib/maven", jars = ["plugins/maven/lib/maven.jar"], srcjar = "@idea-IC-sources//jar")
