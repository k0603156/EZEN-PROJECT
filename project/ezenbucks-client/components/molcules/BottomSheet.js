import * as React from "react";
import { Modalize } from "react-native-modalize";

export default function BottomSheet({
  useRef,
  modalHeight,
  onBackButtonPress,
  onOpen,
  onOpened,
  onClose,
  onClosed,
  withReactModal,
  withHandle,
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
      onOpen={onOpen}
      onOpened={onOpened}
      onClose={onClose}
      onClosed={onClosed}
      withReactModal={withReactModal}
      withHandle={withHandle}
      HeaderComponent={HeaderComponent}
      FloatingComponent={FloatingComponent}
      FooterComponent={FooterComponent}
      adjustToContentHeight={adjustToContentHeight}
    >
      {BodyComponent}
    </Modalize>
  );
}
