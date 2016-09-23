(ns clojure-proj.canvas)

(defn fill-style [ctx color]
  (set! (.-fillStyle ctx) color))

(defn set-size [el [width height]]
  (set! (.-width el) width)
  (set! (.-height el) height))