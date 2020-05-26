import axios from "axios";
import { URL } from "../config";

const request = axios.create({
  baseURL: `${URL}/api`,
  timeout: 5000,
  headers: {
    common: {},
    post: {
      "Content-Type": "application/json",
    },
  },
});

export const fetchListItem = () => request.get("/item");
export const fetchListShop = (location) =>
  request.get(`/shop?x=${location.longitude}&y=${location.latitude}`);
export const fetchCreateOrder = ({ shopId, orderTotalPrice, orderDetailReq }) =>
  request.post("/order", { shopId, orderTotalPrice, orderDetailReq });
