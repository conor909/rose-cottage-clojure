(ns clojure-proj.canvas)

(defn fill-style [ctx color]
  (set! (.-fillStyle ctx) color))

(def screenWidth (.-innerWidth js/window))
(def screenHeight (.-innerWidth js/window))

(defn init-canvas [el]
  (set! (.-width el) screenWidth)
  (set! (.-height el) screenHeight))

(def rain-drop {:x (rand screenWidth) :y (rand screenHeight)})

(defn draw-drop [ctx x y]
  (.save ctx)
  ;(.translate ctx x y)
  (.beginPath ctx)
  (.moveTo ctx (+ x 100) y)
  (.lineTo ctx (+ x 145) (+ y 75))
  (.arc ctx (+ x 100) (+ y 75) 45 0 (* 1 Math/PI))
  (.moveTo ctx (+ x 55) (+ x 75))
  (.lineTo ctx (+ x 100) y)
  (fill-style ctx "rgba(255, 255, 255, 0.5)")
  (.fill ctx)
  (.restore ctx))

(defn make-it-raaiiin [ctx y]
  (dotimes [x 100]
    (draw-drop ctx (rand 10000) y)))