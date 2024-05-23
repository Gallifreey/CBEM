import { get } from 'lodash-es'
import router from '@/router'

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

export function useAntRowSelection<T>(){
	const rowSelection = ref({
		checkStrictly: false,
		onChange: (selectedRowKeys: (string | number)[], selectedRows: T[]) => {
		  console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
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