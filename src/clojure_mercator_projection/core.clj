(ns clojure-mercator-projection.core
  (:require [clojure.contrib.generic.math-functions :refer :all]
            [clojure.contrib.math :refer [expt] :only [expt]]))

(def ^:private PI (. Math PI))

(def ^:private r-major "Equatorial Radius, WGS84" 6378137.0)

(def ^:private r-minor 6356752.314245179)

(def eccent
  (let [temp (/ r-minor r-major)
        es (- 1.0 (* temp temp))]
    (sqrt es)))

(defn deg->rad
  "convert degrees to radians"
  [degree]
  (* degree (/ PI 180)))

(defn rad->deg
  "converts radians to degrees"
  [rad]
  (/ rad (/ PI 180)))

(defn lon-wgs84->mercator
  "convert wgs84 lon to mercator projection"
  [lon]
  (* r-major (deg->rad lon)))

(defn lat-wgs84->mercator
  "converts wgs84 latitude to mercator projection"
  [lat]
  (let [phi (deg->rad lat)
        sinphi (sin phi)
        con (* eccent sinphi)
        com (* 0.5 eccent)
        con2 (expt (/ (- 1.0 con) (+ 1.0 con)) com)
        ts (/ (tan (* 0.5 (- (* PI 0.5) phi))) con2)]
        (- 0 (* r-major (log ts)))))

(defn wgs84->mercator
  "convert wgs84 lat/lng to mercator coordinates"
  [coordinates]
  (let [{:keys [lat lng]} coordinates]
    {:x (lon-wgs84->mercator lng) :y (lat-wgs84->mercator lat)}))

(defn -main [])

