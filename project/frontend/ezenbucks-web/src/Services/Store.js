import { createSlice, createAction } from "@reduxjs/toolkit";

const action = createAction("ACTION");

export default (history) =>
  createSlice({
    name: "store",
    initialState: { history },
    reducers: {
      action: (state) => state,
    },
  });
