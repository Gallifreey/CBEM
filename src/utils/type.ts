import { RangeValue } from "~@/types/form"

export interface OrderWaterFallQueryType{
    order: {
      name: String,
      price: Number,
      publishTime: RangeValue,
      payTime: RangeValue,
      status: String
    }
}

export type UIDType = string | number;

export type deleteType = number[] | string []