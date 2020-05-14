import React from "react";
import ReactDOM from "react-dom";
import { Provider } from "react-redux";
import App from "./App";
import { Router } from "react-router-dom";
import { createBrowserHistory } from "history";
import { InitStore } from "./Services";

const history = createBrowserHistory();

ReactDOM.render(
  <Router history={history}>
    <Provider store={InitStore(history)}>
      <React.StrictMode>
        <App />
      </React.StrictMode>
    </Provider>
  </Router>,
  document.getElementById("root")
);
