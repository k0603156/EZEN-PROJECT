import * as React from "react";
import Button from "../atoms/Button";
import Text from "../atoms/Text";
import Container from "../atoms/Container";
import Row from "../atoms/Row";
import Col from "../atoms/Col";
import Picker from "../atoms/Picker";

export function BottomSheetFormHeader({ title, subTitle }) {
  return (
    <Col>
      <Text size={"md"} color="black" title={title} />
      <Text size={"md"} color="black" textAlign="right" title={subTitle} />
    </Col>
  );
}
export default function BottomSheetFormBody() {
  const [state, setState] = React.useState({
    size: "Tall",
    temp: "Hot",
  });
  const onValueChange = (itemValue, itemIndex) => {
    setState({ ...state, size: itemValue });
  };
  return (
    <Container>
      <Col>
        <Row style={{ justifyContent: "space-between" }}>
          <Text color="black" title="사이즈" />
          <Picker
            selectedValue={state.size}
            style={{ height: 50, width: 150 }}
            onValueChange={onValueChange}
          >
            <Picker.Item label="Tall" value="Tall" />
            <Picker.Item label="Regular" value="Regular" />
          </Picker>
        </Row>
        <Row style={{ justifyContent: "space-between" }}>
          <Text title="Hot/Cold" color="black" />
          <Button title="Hot" />
          <Button title="Cold" />
        </Row>
      </Col>
    </Container>
  );
}

export function BottomSheetFormFooter({
  titlePositive,
  titleNegative,
  onPositive,
  onNegative,
}) {
  return (
    <Row>
      <Button
        title={titlePositive}
        onPress={onPositive}
        style={{ flex: 1, justifyContent: "center" }}
      />
      <Button
        title={titleNegative}
        onPress={onNegative}
        style={{ flex: 1, justifyContent: "center" }}
      />
    </Row>
  );
}
