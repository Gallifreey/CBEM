<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container" ref="refDOM"/>
</template>
<script lang="ts" setup>
import { Area, AreaOptions } from '@antv/g2plot';

const props = defineProps({
  data: {
    type: Object as PropType<Record<string, any>[]>,
    default: () => {
      return {}
    }
  },
  xLabel: {
    type: String,
    default: ""
  },
  yLabel: {
    type: String,
    default: ""
  },
  seriesField: {
    type: String,
    default: ""
  }
})
const refDOM = ref()
const barOptions: AreaOptions = {
  data: props.data,
  xField: props.xLabel,
  yField: props.yLabel,
  seriesField: props.seriesField,
  xAxis: {
    label: {
      style: {
        fill: '#aaaaaa'
      },
      formatter: text => {
        return text + '月';
      }
    }
  },
  annotations: [
    {
      id: '1',
      top: true,
      start: [ 'min', 0 ],
      end: [ 'max', 'min' ],
      style: {
        fill: '#2fc25b'
      }
    },
    {
      id: '2',
      position:  [ '2', 1216 ],
      content: '2月份因逢春节水产销售需求旺盛，\n需求大增',
      lineLength: 20,
      autoAdjust: false,
      style: {
        text: {
          textAlign: 'left',
          stroke: '#fff',
          lineWidth: 2
        },
        point: {
          stroke: '#f5222d'
        }
      }
    }
  ]
}
var barDOM: Area;
onMounted(() => {
  barDOM = new Area(refDOM.value, barOptions);
  barDOM.render();
});
watch(() => props.data, (newValue, oldValue) => {
  oldValue
  barDOM.changeData(toRaw(newValue));
  barDOM.render();
});
onUnmounted(() => {
  barDOM.destroy();
});
</script>
<style lang="less" scoped>

</style>