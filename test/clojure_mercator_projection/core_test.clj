(ns clojure-mercator-projection.core-test
  (:require [clojure.test :refer :all]
            [clojure-mercator-projection.core :refer :all]))

(deftest eccent-test
  (testing "should have correct value"
    (is (= eccent 0.08181919084262157))))

(deftest deg->rad-test
  (testing "converts degrees to radians"
    (is (= (deg->rad 144) 2.5132741228718345))))

(deftest rad->deg-test
  (testing "converts radians to degrees"
    (is (= (rad->deg  2.5132741228718345) 144.0))))

(deftest lat-wsg84->mercator-test
  (testing "converts lon degree to mercator coordinate"
    (is (= (lat-wgs84->mercator 25) 2857692.6111605316))))

