export const STORAGE_AUTHORIZE_KEY = 'token'

export const useAuthorization = createGlobalState(() => useStorage<null | string>(STORAGE_AUTHORIZE_KEY, null))
