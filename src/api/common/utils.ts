
export function getAllBrand(){
    return useGet('/api/brand/list');
}

export function getAllDeliveryState(){
    return useGet('/api/delivery_state/list');
}