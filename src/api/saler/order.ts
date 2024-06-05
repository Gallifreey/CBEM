import { RangeValue } from "~@/types/form";
import { SalerReturnAndExchangeColumnType } from "~@/utils/columns";
import { UIDType } from "~@/utils/type";

interface RAEQueryFormState {
    price: number,
    state: number,
    publishTime: RangeValue
}

export function getRAEList(uid: UIDType){
    return useGet<SalerReturnAndExchangeColumnType[]>('/api/saler/rae/list', {
        uid: uid
    })
}

export function queryRAE(params: RAEQueryFormState){
    return usePost<SalerReturnAndExchangeColumnType[]>('/api/saler/rae/query', {
        params: params
    })
}

