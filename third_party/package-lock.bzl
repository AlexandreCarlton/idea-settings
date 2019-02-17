# Do not edit. bazel-deps autogenerates this file from third_party/dependencies.yaml.
def _jar_artifact_impl(ctx):
    jar_name = "%s.jar" % ctx.name
    ctx.download(
        output=ctx.path("jar/%s" % jar_name),
        url=ctx.attr.urls,
        sha256=ctx.attr.sha256,
        executable=False
    )
    src_name="%s-sources.jar" % ctx.name
    srcjar_attr=""
    has_sources = len(ctx.attr.src_urls) != 0
    if has_sources:
        ctx.download(
            output=ctx.path("jar/%s" % src_name),
            url=ctx.attr.src_urls,
            sha256=ctx.attr.src_sha256,
            executable=False
        )
        srcjar_attr ='\n    srcjar = ":%s",' % src_name

    build_file_contents = """
package(default_visibility = ['//visibility:public'])
java_import(
    name = 'jar',
    tags = ['maven_coordinates={artifact}'],
    jars = ['{jar_name}'],{srcjar_attr}
)
filegroup(
    name = 'file',
    srcs = [
        '{jar_name}',
        '{src_name}'
    ],
    visibility = ['//visibility:public']
)\n""".format(artifact = ctx.attr.artifact, jar_name = jar_name, src_name = src_name, srcjar_attr = srcjar_attr)
    ctx.file(ctx.path("jar/BUILD"), build_file_contents, False)
    return None

jar_artifact = repository_rule(
    attrs = {
        "artifact": attr.string(mandatory = True),
        "sha256": attr.string(mandatory = True),
        "urls": attr.string_list(mandatory = True),
        "src_sha256": attr.string(mandatory = False, default=""),
        "src_urls": attr.string_list(mandatory = False, default=[]),
    },
    implementation = _jar_artifact_impl
)

def jar_artifact_callback(hash):
    src_urls = []
    src_sha256 = ""
    source=hash.get("source", None)
    if source != None:
        src_urls = [source["url"]]
        src_sha256 = source["sha256"]
    jar_artifact(
        artifact = hash["artifact"],
        name = hash["name"],
        urls = [hash["url"]],
        sha256 = hash["sha256"],
        src_urls = src_urls,
        src_sha256 = src_sha256
    )
    native.bind(name = hash["bind"], actual = hash["actual"])


def list_dependencies():
    return [
    {"artifact": "com.fasterxml.jackson.core:jackson-annotations:2.9.8", "lang": "java", "sha1": "ba7f0e6f8f1b28d251eeff2a5604bed34c53ff35", "sha256": "fdca896161766ca4a2c3e06f02f6a5ede22a5b3a55606541cd2838eace08ca23", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.9.8/jackson-annotations-2.9.8.jar", "source": {"sha1": "78430356aa8c7a1227f97c544e6248630a47a17a", "sha256": "134c1891587aab185730b3bf74224985e24ae483bdf39f9921140b702c8fc41a", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.9.8/jackson-annotations-2.9.8-sources.jar"} , "name": "com_fasterxml_jackson_core_jackson_annotations", "actual": "@com_fasterxml_jackson_core_jackson_annotations//jar", "bind": "jar/com/fasterxml/jackson/core/jackson_annotations"},
    {"artifact": "com.fasterxml.jackson.core:jackson-core:2.9.8", "lang": "java", "sha1": "0f5a654e4675769c716e5b387830d19b501ca191", "sha256": "d934dab0bd48994eeea2c1b493cb547158a338a80b58c4fbc8e85fb0905e105f", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.9.8/jackson-core-2.9.8.jar", "source": {"sha1": "ecaea301e166a0b48f11615864246de739b6619b", "sha256": "4ab3c312f46ddf259de240515c301c99c3a478a749d0ecaaf4395a157a646b33", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/2.9.8/jackson-core-2.9.8-sources.jar"} , "name": "com_fasterxml_jackson_core_jackson_core", "actual": "@com_fasterxml_jackson_core_jackson_core//jar", "bind": "jar/com/fasterxml/jackson/core/jackson_core"},
    {"artifact": "com.fasterxml.jackson.core:jackson-databind:2.9.8", "lang": "java", "sha1": "11283f21cc480aa86c4df7a0a3243ec508372ed2", "sha256": "2351c3eba73a545db9079f5d6d768347ad72666537362c8220fe3e950a55a864", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.9.8/jackson-databind-2.9.8.jar", "source": {"sha1": "f66792d499a6fea6c7a743558f940e0ebf775ce3", "sha256": "d6b099786ebb86566c44b15b09fde8ba2055f84ca7e98c63677ba8219f04d580", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.9.8/jackson-databind-2.9.8-sources.jar"} , "name": "com_fasterxml_jackson_core_jackson_databind", "actual": "@com_fasterxml_jackson_core_jackson_databind//jar", "bind": "jar/com/fasterxml/jackson/core/jackson_databind"},
    {"artifact": "com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.9.8", "lang": "java", "sha1": "a1c807329eb0c75976aeb5961a506b3516ffeae3", "sha256": "ec6c80f083d9f0f5530bae59fe7ce359e07b8b562d7e3dbe548e33c284deed22", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.9.8/jackson-dataformat-yaml-2.9.8.jar", "source": {"sha1": "5333e788a93d55bc87628e16f799ce0d03ad7a59", "sha256": "3712cebf21f28f0e34ece8cd32b6308713db775b77c2b43024dfe8f6e1878928", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/dataformat/jackson-dataformat-yaml/2.9.8/jackson-dataformat-yaml-2.9.8-sources.jar"} , "name": "com_fasterxml_jackson_dataformat_jackson_dataformat_yaml", "actual": "@com_fasterxml_jackson_dataformat_jackson_dataformat_yaml//jar", "bind": "jar/com/fasterxml/jackson/dataformat/jackson_dataformat_yaml"},
    {"artifact": "com.fasterxml.jackson.datatype:jackson-datatype-guava:2.9.8", "lang": "java", "sha1": "b7f7819800f8ebe51a03dd951636f6dbc6245ce6", "sha256": "b13534d712572c848faaf27f7fd4fa2f2a11cef4185d79d995aceef3a778ee59", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/datatype/jackson-datatype-guava/2.9.8/jackson-datatype-guava-2.9.8.jar", "source": {"sha1": "f50bd532f7a898c3bb889dfecf9a5bc8dd354940", "sha256": "6157b8b384302507b0cd818e5d8fc8058babc4b2617f5fe4cd4e936c34da8ecc", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/datatype/jackson-datatype-guava/2.9.8/jackson-datatype-guava-2.9.8-sources.jar"} , "name": "com_fasterxml_jackson_datatype_jackson_datatype_guava", "actual": "@com_fasterxml_jackson_datatype_jackson_datatype_guava//jar", "bind": "jar/com/fasterxml/jackson/datatype/jackson_datatype_guava"},
    {"artifact": "com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.9.8", "lang": "java", "sha1": "bcd02aa9195390e23747ed40bf76be869ad3a2fb", "sha256": "6d0e43d927c63b25d94130dc95d9b26c031e4516a2b1dfb984dea99bfd49b003", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.9.8/jackson-datatype-jdk8-2.9.8.jar", "source": {"sha1": "d82c445cc6e5745e7d6eb94b14ca5c2c895369d2", "sha256": "00988940ad4f4a3a93d5ea0585581cacb3a2204ef16f65a04a2fcd153640e07b", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.9.8/jackson-datatype-jdk8-2.9.8-sources.jar"} , "name": "com_fasterxml_jackson_datatype_jackson_datatype_jdk8", "actual": "@com_fasterxml_jackson_datatype_jackson_datatype_jdk8//jar", "bind": "jar/com/fasterxml/jackson/datatype/jackson_datatype_jdk8"},
    {"artifact": "com.google.code.findbugs:jsr305:3.0.2", "lang": "java", "sha1": "25ea2e8b0c338a877313bd4672d3fe056ea78f0d", "sha256": "766ad2a0783f2687962c8ad74ceecc38a28b9f72a2d085ee438b7813e928d0c7", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar", "source": {"sha1": "b19b5927c2c25b6c70f093767041e641ae0b1b35", "sha256": "1c9e85e272d0708c6a591dc74828c71603053b48cc75ae83cce56912a2aa063b", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2-sources.jar"} , "name": "com_google_code_findbugs_jsr305", "actual": "@com_google_code_findbugs_jsr305//jar", "bind": "jar/com/google/code/findbugs/jsr305"},
    {"artifact": "com.google.errorprone:error_prone_annotations:2.2.0", "lang": "java", "sha1": "88e3c593e9b3586e1c6177f89267da6fc6986f0c", "sha256": "6ebd22ca1b9d8ec06d41de8d64e0596981d9607b42035f9ed374f9de271a481a", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/errorprone/error_prone_annotations/2.2.0/error_prone_annotations-2.2.0.jar", "source": {"sha1": "a8cd7823aa1dcd2fd6677c0c5988fdde9d1fb0a3", "sha256": "626adccd4894bee72c3f9a0384812240dcc1282fb37a87a3f6cb94924a089496", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/errorprone/error_prone_annotations/2.2.0/error_prone_annotations-2.2.0-sources.jar"} , "name": "com_google_errorprone_error_prone_annotations", "actual": "@com_google_errorprone_error_prone_annotations//jar", "bind": "jar/com/google/errorprone/error_prone_annotations"},
    {"artifact": "com.google.guava:failureaccess:1.0.1", "lang": "java", "sha1": "1dcf1de382a0bf95a3d8b0849546c88bac1292c9", "sha256": "a171ee4c734dd2da837e4b16be9df4661afab72a41adaf31eb84dfdaf936ca26", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar", "source": {"sha1": "1d064e61aad6c51cc77f9b59dc2cccc78e792f5a", "sha256": "092346eebbb1657b51aa7485a246bf602bb464cc0b0e2e1c7e7201fadce1e98f", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1-sources.jar"} , "name": "com_google_guava_failureaccess", "actual": "@com_google_guava_failureaccess//jar", "bind": "jar/com/google/guava/failureaccess"},
    {"artifact": "com.google.guava:guava:27.0.1-jre", "lang": "java", "sha1": "bd41a290787b5301e63929676d792c507bbc00ae", "sha256": "e1c814fd04492a27c38e0317eabeaa1b3e950ec8010239e400fe90ad6c9107b4", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/guava/guava/27.0.1-jre/guava-27.0.1-jre.jar", "source": {"sha1": "cb5c1119df8d41a428013289b193eba3ccaf5f60", "sha256": "cba2e5680186062f42998b895a5e9a9ceccbaab94644ccc9f35bb73c2b2c7d8e", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/guava/guava/27.0.1-jre/guava-27.0.1-jre-sources.jar"} , "name": "com_google_guava_guava", "actual": "@com_google_guava_guava//jar", "bind": "jar/com/google/guava/guava"},
    {"artifact": "com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava", "lang": "java", "sha1": "b421526c5f297295adef1c886e5246c39d4ac629", "sha256": "b372a037d4230aa57fbeffdef30fd6123f9c0c2db85d0aced00c91b974f33f99", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar", "name": "com_google_guava_listenablefuture", "actual": "@com_google_guava_listenablefuture//jar", "bind": "jar/com/google/guava/listenablefuture"},
    {"artifact": "com.google.j2objc:j2objc-annotations:1.1", "lang": "java", "sha1": "ed28ded51a8b1c6b112568def5f4b455e6809019", "sha256": "2994a7eb78f2710bd3d3bfb639b2c94e219cedac0d4d084d516e78c16dddecf6", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1.jar", "source": {"sha1": "1efdf5b737b02f9b72ebdec4f72c37ec411302ff", "sha256": "2cd9022a77151d0b574887635cdfcdf3b78155b602abc89d7f8e62aba55cfb4f", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/com/google/j2objc/j2objc-annotations/1.1/j2objc-annotations-1.1-sources.jar"} , "name": "com_google_j2objc_j2objc_annotations", "actual": "@com_google_j2objc_j2objc_annotations//jar", "bind": "jar/com/google/j2objc/j2objc_annotations"},
    {"artifact": "org.checkerframework:checker-qual:2.5.2", "lang": "java", "sha1": "cea74543d5904a30861a61b4643a5f2bb372efc4", "sha256": "64b02691c8b9d4e7700f8ee2e742dce7ea2c6e81e662b7522c9ee3bf568c040a", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/checkerframework/checker-qual/2.5.2/checker-qual-2.5.2.jar", "source": {"sha1": "ebb8ebccd42218434674f3e1d9022c13df1c19f8", "sha256": "821c5c63a6f156a3bb498c5bbb613580d9d8f4134131a5627d330fc4018669d2", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/checkerframework/checker-qual/2.5.2/checker-qual-2.5.2-sources.jar"} , "name": "org_checkerframework_checker_qual", "actual": "@org_checkerframework_checker_qual//jar", "bind": "jar/org/checkerframework/checker_qual"},
    {"artifact": "org.codehaus.mojo:animal-sniffer-annotations:1.17", "lang": "java", "sha1": "f97ce6decaea32b36101e37979f8b647f00681fb", "sha256": "92654f493ecfec52082e76354f0ebf87648dc3d5cec2e3c3cdb947c016747a53", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/codehaus/mojo/animal-sniffer-annotations/1.17/animal-sniffer-annotations-1.17.jar", "source": {"sha1": "8fb5b5ad9c9723951b9fccaba5bb657fa6064868", "sha256": "2571474a676f775a8cdd15fb9b1da20c4c121ed7f42a5d93fca0e7b6e2015b40", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/codehaus/mojo/animal-sniffer-annotations/1.17/animal-sniffer-annotations-1.17-sources.jar"} , "name": "org_codehaus_mojo_animal_sniffer_annotations", "actual": "@org_codehaus_mojo_animal_sniffer_annotations//jar", "bind": "jar/org/codehaus/mojo/animal_sniffer_annotations"},
    {"artifact": "org.immutables:value:2.7.4", "lang": "java", "sha1": "5bb97ea9bdd04458f1eee1f3bb47159b51170206", "sha256": "b75bf58711e1c33719f04e84e3dc22341148b587b6023ef2021169f25a6fb7c2", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/immutables/value/2.7.4/value-2.7.4.jar", "source": {"sha1": "bb325cd974ee02859468a4dedcde06cf312cc39a", "sha256": "7e4185204d14e0dabaf5b4e060e4314f11e07d8cc0a4d78408e97506c761d6c4", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/immutables/value/2.7.4/value-2.7.4-sources.jar"} , "name": "org_immutables_value", "actual": "@org_immutables_value//jar", "bind": "jar/org/immutables/value"},
    {"artifact": "org.yaml:snakeyaml:1.23", "lang": "java", "sha1": "ec62d74fe50689c28c0ff5b35d3aebcaa8b5be68", "sha256": "13009fb5ede3cf2be5a8d0f1602155aeaa0ce5ef5f9366892bd258d8d3d4d2b1", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/yaml/snakeyaml/1.23/snakeyaml-1.23.jar", "source": {"sha1": "1186bcf89d33080275bab74a0b0f495af5c812ef", "sha256": "ec649cde6353321553eebc3ccf7c473663113d17d724df94541de88e06101d53", "repository": "http://central.maven.org/maven2/", "url": "http://central.maven.org/maven2/org/yaml/snakeyaml/1.23/snakeyaml-1.23-sources.jar"} , "name": "org_yaml_snakeyaml", "actual": "@org_yaml_snakeyaml//jar", "bind": "jar/org/yaml/snakeyaml"},
    ]

def maven_dependencies(callback = jar_artifact_callback):
    for hash in list_dependencies():
        callback(hash)
