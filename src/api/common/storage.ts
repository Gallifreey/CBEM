import { RangeValue } from "~@/types/form";
import { VendorStorageColumnType } from "~@/utils/columns";
import { UIDType } from "~@/utils/type";

interface StorageQueryFormStateParams {
    name: string,
    brand: string,
    authTime: RangeValue
}

interface StorageAuthParams{
    sid: number,
    bid: number
}

export function getAuthedStorageList(uid: UIDType){
    return useGet<VendorStorageColumnType[]>('/api/vendor/storage/list', {
        uid: uid
    })
}

export function queryStorage(params: StorageQueryFormStateParams){
    return usePost<VendorStorageColumnType[]>('/api/vendor/storage/query', {
        params: params
    })
}

export function authNewStorage(params: StorageAuthParams){
    return usePost('/api/vendor/storage/auth', params)
}

