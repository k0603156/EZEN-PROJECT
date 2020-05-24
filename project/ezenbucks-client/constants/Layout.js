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

export const Size = (size) => {
  switch (size) {
    case "xxs":
      return "10px";
    case "xs":
      return "14px";
    case "sm":
      return "16px";
    case "md":
      return "21px";
    case "lg":
      return "24px";
    case "xl":
      return "26px";
    case "xxl":
      return "28px";
  }
};
