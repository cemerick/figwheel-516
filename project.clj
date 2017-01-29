(defproject foo/bar "0.0.1-SNAPSHOT"
  :min-lein-version "2.6.1"
  :source-paths ["src"]
  :resource-paths ["node_modules"]
  :dependencies [[org.clojure/clojure "1.9.0-alpha9"]
                 [org.clojure/clojurescript "1.9.89" #_"1.9.456"]
                 [reagent "0.6.0-rc"]
                 ; figwheel
                 [binaryage/devtools "0.7.2"]
                 [figwheel-sidecar "0.5.9-SNAPSHOT"]
                 [com.cemerick/piggieback "0.2.1"]]

  :npm {:dependencies [[react-draggable "2.2.1"]]}

  :plugins [[lein-cljsbuild "1.1.3" :exclusions [org.clojure/clojure]]
            [lein-npm "0.6.2"]
            [lein-figwheel "0.5.9-SNAPSHOT"]]

  :cljsbuild {:builds
              {"min" {:source-paths ["src"]
                      :compiler {:output-to "target/classes/public/js/viewer.js"
                                 :main foo.bar
                                 :optimizations :advanced
                                 :pretty-print false
                                 :language-in :ecmascript5}}
               "dev" {:source-paths ["src"]
                      :compiler {:main foo.bar
                                 :asset-path "/js/"
                                 :output-to "target/classes/public/js/viewer.js"
                                 :output-dir "target/classes/public/js/"
                                 :source-map-timestamp true
                                 ;:infer-externs true
                                 ;; To console.log CLJS data-structures make sure you enable devtools in Chrome
                                 ;; https://github.com/binaryage/cljs-devtools
                                 :preloads [devtools.preload]}}}}

  :figwheel {:builds [{:id "dev"
                       :source-paths ["src"]
                       :figwheel {:on-jsload "foo.bar/on-js-reload"}
                       :compiler {:main foo.bar
                                  :asset-path "/js/"
                                  :output-to "target/classes/public/js/viewer.js"
                                  :output-dir "target/classes/public/js/"
                                  :source-map-timestamp true
                                  ;:infer-externs true
                                  ;; To console.log CLJS data-structures make sure you enable devtools in Chrome
                                  ;; https://github.com/binaryage/cljs-devtools
                                  :preloads [devtools.preload]}}]})
