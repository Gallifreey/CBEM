import { CommodityData, RangeValue } from "~@/types/form";
import { CommdityColumnType } from "~@/utils/columns";
import { UIDType, deleteType } from "~@/utils/type";

interface QueryCommodityFormState {
    name: string,
    brand: string,
    deliveryState: string,
    publishTime: RangeValue,
    salePrice: number,
    status: string,
}

export function getCommodityListByUID(uid: UIDType){
    return useGet<CommdityColumnType[]>('/api/vendor/commodity/list', {
        uid: uid
    })
}

export function queryCommodity(params: QueryCommodityFormState){
    return usePost<CommdityColumnType[]>('/api/vendor/commodity/query', {
        params: params
    })
}

export function deleteCommodity(params: deleteType){
    return useDelete('/api/vendor/commodity/delete', {
        ids: params
    })
}

export function getCommodityDetailsByCID(id: UIDType){
    return useGet<CommdityColumnType>('/api/vendor/commodity/details', {
        id: id
    });
}

export function addCommodity(params: CommodityData){
    return usePost('/api/vendor/commodity/add', {
        params: params
    })
}

export function modifyCommodity(params: CommodityData){
    return usePut('/api/vendor/commodity/modify', params)
}