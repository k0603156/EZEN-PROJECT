import { Dimensions, PixelRatio } from "react-native";

const width = Dimensions.get("window").width;
const height = Dimensions.get("window").height;
const scale = width / 320;

export function normalize(size) {
  const newSize = size * scale;
  if (Platform.OS === "ios") {
    return Math.round(PixelRatio.roundToNearestPixel(newSize));
  } else {
    return Math.round(PixelRatio.roundToNearestPixel(newSize)) - 2;
  }
}
export default {
  window: {
    width,
    height,
    scale,
  },
  isSmallDevice: width < 375,
};
