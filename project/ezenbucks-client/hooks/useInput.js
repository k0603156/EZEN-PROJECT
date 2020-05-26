import * as React from "react";

export default function useInput(initialValue) {
  const [value, setValue] = React.useState(initialValue);
  const onChange = (text) => {
    setValue(text);
  };
  return { value, onChange };
}
