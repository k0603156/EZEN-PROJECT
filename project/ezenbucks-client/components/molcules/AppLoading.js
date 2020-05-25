import * as React from "react";
import { AppLoading } from "expo";
import Colors from "../../constants/Colors";
import Container from "../atoms/Container";
import Text from "../atoms/Text";

export default function ({ startAsync, onFinish, onError, autoHideSplash }) {
  return (
    <Container
      style={{
        display: "flex",
        flex: 1,
        alignItems: "center",
        justifyContent: "center",
        backgroundColor: Colors.black,
      }}
    >
      <Text title="Loading...." />
      <AppLoading
        startAsync={startAsync}
        onFinish={onFinish}
        onError={onError}
        autoHideSplash={autoHideSplash}
      />
    </Container>
  );
}
