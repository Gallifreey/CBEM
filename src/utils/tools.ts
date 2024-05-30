import { get } from 'lodash-es'
import router from '@/router'
import { Graph } from '@antv/x6'
import Dayjs from 'dayjs'

export function getQueryParam(param: string | string[], defaultVal = '') {
  const query = router.currentRoute.value?.query ?? {}
  const val = get(query, param) ?? defaultVal
  return decodeURIComponent(val)
}

export function useVModel(props: any, propName: string, emits: any, func = () => {}){
	const show = computed({
		get(){
			return props[propName]
		},
		set(value){
			emits(`update:${propName}`, value)
			func()
		}
	})
	return show;
}

export function useAntRowSelection<T>(rowSelectedKeys: any){
	const rowSelection = ref({
		checkStrictly: false,
		onChange: (selectedRowKeys: (string | number)[], selectedRows: T[]) => {
			rowSelectedKeys.value = selectedRowKeys
		},
		onSelect: (record: T, selected: boolean, selectedRows: T[]) => {
		  console.log(record, selected, selectedRows);
		},
		onSelectAll: (selected: boolean, selectedRows: T[], changeRows: T[]) => {
		  console.log(selected, selectedRows, changeRows);
		},
	});
	return rowSelection;
}

export function addIncreasedNumber(data: Array<Object>){
	let index = 1;
	data.forEach((obj: any) => {
		obj['id'] = index++;
	})
}

export function objectKeysArrayFilter(data: Array<Object>, keys: Array<String>){
	data.filter((obj: any) => {
		for(const key in obj){
			if(key in keys) delete obj[key];
		}
		return obj;
	})
}

export function objectValuesArrayFilter(data: Array<Object>, values: Array<String>, keys: Array<String>){
	data.filter((obj: any) => {
		for(const key in obj){
			if(key in keys){
				for(const value in values){
					if(value in values) delete obj[key];
				}
			}
		}
		return obj;
	})
}

export function userCreateVueNode(graph: Graph){
	const node = (
		id: string,
		x?: number,
		y?: number,
		shape?: string,
		data?: object
	) => {
		return graph.createNode({id, x, y, shape, data})
	}
	return node;
}

export function generateObjectByArray(data: Array<any>){
	const obj: Array<Object> = [];
	let index = 0;
	data.forEach((d: any) => {
		obj.push({
			value: ++index,
			label: d
		})
	})
	return obj;
}

export function dayjs2TimeString(day: Dayjs | Dayjs[]){
	const res: string[] = []
	if(day instanceof Dayjs) day = [day];
	day.forEach((d: Dayjs) => {
		res.push(d.format("yyyy/MM/dd HH:mm:ss"))
	})
	return res;
}

export function plotData2SeriesData(data: Array<object>, seriesField: string[], targetField: string){
	const resObj: Array<Object> = [];
	data.forEach((d: object) => {
		for(const key in Object.keys(d)){
			if(key in seriesField){
				const obj = {
					
				}
			}
		}
	})
	return resObj;
}