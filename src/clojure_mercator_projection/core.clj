(ns clojure-mercator-projection.core
  (:require [clojure.contrib.generic.math-functions :refer :all]
            [clojure.contrib.math :refer [expt] :only [expt]]))

(def PI (. Math PI))

(def rad-per-deg (/ PI 180.0))

(def equatorial-radius 6378137.0)

(defn lon-wgs84->mercator
  "convert wgs84 lon to mercator projection"
  [lon]
  (* lon rad-per-deg equatorial-radius))

(defn lat-wgs84->mercator
  "converts wgs84 latitude to mercator projection"
  [lat]
  (* (log (tan (+ (/ PI 4.0) (* lat (/ rad-per-deg 2.0))))) equatorial-radius))

(defn wgs84->mercator
  "convert wgs84 lat/lng to mercator coordinates"
  [coordinates]
  (let [{:keys [lat lng]} coordinates]
    {:x (lon-wgs84->mercator lng) :y (lat-wgs84->mercator lat)}))

(defn -main [])

