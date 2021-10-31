(ns sketch.core
  (:require [sketch.dynamic :as dynamic])
  (:require [quil.core :as q]
            [quil.middleware :as m]))

(q/defsketch sketch
  :title "Cubic Disarray"
  :size [3440 1440]
  :draw dynamic/draw
  :features [:keep-on-top])

(defn refresh []
  (use :reload 'sketch.dynamic)
  (.loop sketch))
