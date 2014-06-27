(ns clojure-mercator-projection.core-test
  (:require [clojure.test :refer :all]
            [clojure-mercator-projection.core :refer :all]))

(deftest wgs84->mercator-test
  (testing "converts wgs84 to mercator"
    (is (= (wgs84->mercator {:lat 26 :lng 26}) {:x 2894306.760625113, :y 2999080.9434706415}))))

