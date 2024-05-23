
export function getItem(key:string){
    const item = window.localStorage.getItem(key);
    if(item === undefined || item === null) {
        // 请求后端
    }
    return item;
}