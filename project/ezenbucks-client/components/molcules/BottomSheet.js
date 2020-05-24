import * as React from "react";
import { Modalize } from "react-native-modalize";

export default function BottomSheet({
  useRef,
  modalHeight,
  onBackButtonPress,
  onOpened,
  onClosed,
  HeaderComponent,
  BodyComponent,
  FloatingComponent,
  FooterComponent,
  adjustToContentHeight,
}) {
  return (
    <Modalize
      ref={useRef}
      modalHeight={modalHeight}
      onBackButtonPress={onBackButtonPress}
      onOpened={onOpened}
      onClosed={onClosed}
      HeaderComponent={HeaderComponent}
      FloatingComponent={FloatingComponent}
      FooterComponent={FooterComponent}
      adjustToContentHeight={adjustToContentHeight}
    >
      {BodyComponent}
    </Modalize>
  );
}
