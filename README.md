### Some math to convert World Goedetic System coordinates to Mercator projection

https://clojars.org/clojure-mercator-projection

```clojure
clojure-mercator-projection.core=> (wgs84->mercator {:lat 41.897865137687376 :lng -87.64455200350926})
{:x -9756546.899835236, :y 5117150.255835393}
```
