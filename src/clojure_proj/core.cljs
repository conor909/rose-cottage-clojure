(ns clojure-proj.core
  (:require [reagent.core :as reagent]
            [clojure-proj.canvas :as canvas]))

(enable-console-print!)

(defn header-component [props]
  (let [subHead (:subHead props) head (:head props)]
       [:div  {:style {:textAlign "center" :fontFamily "'Schoolbell', cursive" :color "#fff" :textShadow "0px 0px 10px #fff"}}
       [:div  {:style {:fontSize "2em"}} subHead]
       [:div  {:style {:fontSize "3em"}} head]]))

(defn app []
  [:div {
       :style {
         :position "relative"
         :height "100%"
         :background ["linear-gradient(180deg, #152b52 7%, #2c9ab3 51%, #f3f3d1 90%", "#f3f3d1"]
       }
    }
    [canvas/canvas]
    [header-component {:subHead "Welcome to" :head "Rose Cottage"}]
   ]
)

(def environment {:time "It is currently day time"
                  :weather "It is currently raining"})

(defn run []
  (reagent/render [app] (.getElementById js/document "app-container"))
    (canvas/init-canvas)
    (if (= (get environment :weather) "It is currently raining")
        (canvas/make-it-raaiiin 0 0)
    )
)

(run)

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )

