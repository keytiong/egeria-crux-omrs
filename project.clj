(defproject io.kosong.egeria/egeria-xtdb-omrs "0.1.0-SNAPSHOT"
  :description "Egeria open metadata repository implemented in XTDB"
  :url "https://github.com/keytiong/egeria-xtdb-orms"
  :license {:name "The MIT License"
            :url  "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 #_[org.odpi.egeria/open-metadata-types "3.3"]
                 #_[org.odpi.egeria/repository-services-apis "3.3"]
                 [org.odpi.egeria/repository-services-implementation "3.3" :exclusions
                  [org.odpi.egeria/connector-configuration-factory
                   #_org.odpi.egeria/graph-repository-connector
                   #_org.odpi.egeria/inmemory-repository-connector]]
                 [com.xtdb/xtdb-core "1.19.0"]]
  :target-path "target/%s"
  :source-paths ["src/main/clojure"]
  :java-source-paths ["src/main/java"]
  :resource-paths ["src/main/resources"]
  :test-paths ["src/test/clojure"]
  #_(:aot [io.kosong.egeria.omrs.xtdb.xtdb-metadata-collection])
  :profiles {:dev     {:plugins        [[lein-midje "3.2.1"]]
                       :dependencies   [[clojure-complete "0.2.5"]
                                        [midje "1.9.9"]
                                        [org.clojure/tools.namespace "1.1.0"]
                                        [integrant/repl "0.3.1"]
                                        [nrepl "0.6.0"]
                                        [org.testcontainers/kafka "1.15.2"]
                                        [clj-http "2.3.0"]
                                        [org.clojure/data.json "2.0.1"]
                                        [com.xtdb/xtdb-rocksdb "1.19.0"]
                                        #_[org.odpi.egeria/asset-reader-csv-sample "3.3"]]
                       :source-paths   ["dev"]
                       :resource-paths ["dev-resources"
                                        "src/test/resources"]}
             :reveal  {:dependencies [[vlaaad/reveal "1.2.186"]]
                       :repl-options {:nrepl-middleware [vlaaad.reveal.nrepl/middleware]}}
             :uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
