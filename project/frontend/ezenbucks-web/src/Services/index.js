import { configureStore } from "@reduxjs/toolkit";
import Store from "./Store";

export const InitStore = (history) => {
  const { reducer } = Store(history);
  return configureStore({ reducer: reducer });
};
