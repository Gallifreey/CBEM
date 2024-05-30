import { VendorOrderWaterFallColumnType } from "~@/utils/columns";
import { OrderWaterFallQueryType } from "~@/utils/type";

export function getOrderWaterFallList(uid: number | string){
    return useGet<VendorOrderWaterFallColumnType[], number | string>('/api/statistics/order/list', uid)
}

export function queryOrderWaterFall(params: OrderWaterFallQueryType){
    return useGet<VendorOrderWaterFallColumnType[], OrderWaterFallQueryType>('/api/statistics/order/query', params)
}
