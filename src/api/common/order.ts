import { RangeValue } from "~@/types/form"

export interface OrderListParams {
    name: string,
    description: string,
    source: string,
    target: string,
    publishTime: string,
    state: number,
    key?: number
}

export interface OrderModifyParams {
    description?: string,
    source: string,
    target: string,
    memo?: string
}

export interface OrderListQueryParams {
    source: string,
    target: string,
    publishTime: RangeValue
}

export interface OrderListUIDQueryParams {
    uid: number
}

export interface OrderDeleteParams {
    id: number | number[] | string | string[]
}

export function getOrdersByUIDApi(params: OrderListUIDQueryParams) {
    return useGet<OrderListParams, OrderListUIDQueryParams>('/order/list', params, {
        token: true,
        customDev: true,
        loading: false,
    })
}

export function getOrdersByQueryApi(params: OrderListQueryParams){
    return useGet<OrderListQueryParams>('/order/query', params)
}

export function modifyOrderApi(params: OrderModifyParams){
    return usePut('/order/update', params)
}

export function deleteOrderApi(parmas: OrderDeleteParams){
    return useDelete('/order/delete', parmas)
}