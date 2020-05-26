import * as React from "react";
import styled from "styled-components";
import Button from "../atoms/Button";
import Text from "../atoms/Text";
import Container from "../atoms/Container";
import Row from "../atoms/Row";
import Col from "../atoms/Col";
import Picker from "../atoms/Picker";

const Label = styled(Text)`
  height: 50px;
  width: 100px;
  line-height: 50px;
`;

export function BottomSheetFormHeader({ title = "", subTitle = "" }) {
  return (
    <Col>
      <Text size={"xl"} color="black" title={title} />
      <Text size={"md"} color="black" textAlign="right" title={subTitle} />
    </Col>
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
export function BottomSheetSelect({
  title,
  options,
  selectedOption,
  onValueChange,
}) {
  return (
    <Col>
      <Row style={{ flex: 1, justifyContent: "space-around" }}>
        <Label title={title} color="black" />
        <Picker
          selectedValue={selectedOption}
          onValueChange={onValueChange}
          style={{ flex: 1 }}
          mode="dropdown"
        >
          {options.map((option) => (
            <Picker.Item label={option} value={option} />
          ))}
        </Picker>
      </Row>
    </Col>
  );
}
export function BottomSheetToggle({
  title,
  options,
  selectedOption,
  onValueChange,
}) {
  const backgroundColor = (option) =>
    selectedOption === option ? "black" : "white";
  const color = (option) => (selectedOption === option ? "white" : "black");
  return (
    <Col>
      <Row style={{ flex: 1, justifyContent: "space-around" }}>
        <Label title={title} color="black" />
        {options.map((option) => (
          <Button
            title={option}
            onPress={(e) => onValueChange(option)}
            style={{
              flex: 1,
              border: "1px solid black",
              borderRadius: 4,
              backgroundColor: backgroundColor(option),
            }}
            textStyle={{
              color: color(option),
            }}
          />
        ))}
      </Row>
    </Col>
  );
}
