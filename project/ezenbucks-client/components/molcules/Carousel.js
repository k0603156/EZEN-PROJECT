import * as React from "react";
import Carousel from "react-native-snap-carousel";
import Layout, { normalize } from "../../constants/Layout";

export default function ProductCarousel({
  data,
  renderItem,
  onScroll,
  onSnapToItem,
}) {
  return (
    <Carousel
      data={data}
      renderItem={renderItem}
      onScroll={onScroll}
      onSnapToItem={onSnapToItem}
      sliderWidth={Layout.window.width}
      itemWidth={Layout.window.width}
    />
  );
}
