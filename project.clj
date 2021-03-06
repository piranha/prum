(defproject prum "0.1.0-SNAPSHOT"
  :description "Rum with Preact"
  :url "https://github.com/roman01la/prum"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [rum "0.10.7"
                  :exclusions [cljsjs/react cljsjs/react-dom]]]

  :plugins [[lein-figwheel "0.5.8"]
            [lein-cljsbuild "1.1.4" :exclusions [[org.clojure/clojure]]]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel true
                :compiler {:main prum.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/prum.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true
                           :preloads [devtools.preload]
                           :language-in :ecmascript5
                           :language-out :ecmascript5
                           :externs ["js/externs/preact.js"
                                     "js/externs/react.js"
                                     "js/externs/react-dom.js"]
                           :foreign-libs [{:file "js/proptypes.js"
                                           :provides ["proptypes.core"]
                                           :module-type :commonjs}
                                          {:file "js/preact.js"
                                           :provides ["preact.core"]
                                           :module-type :commonjs}
                                          {:file "js/preact-compat.js"
                                           :provides ["preact.compat"]
                                           :module-type :commonjs}]}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/compiled/prum.js"
                           :main prum.core
                           :optimizations :advanced
                           :pretty-print false
                           :language-in :ecmascript5
                           :language-out :ecmascript5
                           :externs ["js/externs/preact.js"
                                     "js/externs/react.js"
                                     "js/externs/react-dom.js"]
                           :foreign-libs [{:file "js/proptypes.js"
                                           :provides ["proptypes.core"]
                                           :module-type :commonjs}
                                          {:file "js/preact.js"
                                           :provides ["preact.core"]
                                           :module-type :commonjs}
                                          {:file "js/preact-compat.js"
                                           :provides ["preact.compat"]
                                           :module-type :commonjs}]}}]}

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles {:dev {:dependencies [[binaryage/devtools "0.8.2"]
                                  [figwheel-sidecar "0.5.8"]]
                   :source-paths ["src" "dev"]}})
