export interface CommodityBoardType {
  update: string,
  duration: [string, string],
  results: {
    status: number,
    value: number
  },
  conversion: {
    value: number,
    increase: number
  },
  increaseTop5: {
    title: string,
    value: number
  }[],
  decreaseTop5: {
    title: string,
    value: number
  }[]
}