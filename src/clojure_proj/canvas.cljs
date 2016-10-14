(ns clojure-proj.canvas)

(defn fill-style [ctx color]
  (set! (.-fillStyle ctx) color)
  )
(defn init-canvas [el]
  (set! (.-width el) (.-innerWidth js/window))
  (set! (.-height el) (.-innerWidth js/window)))

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
  (dotimes [x 1000]
    (draw-drop ctx x y)))