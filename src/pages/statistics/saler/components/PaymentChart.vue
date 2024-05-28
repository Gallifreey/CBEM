<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="line-container" ref="refDOM"></div>
</template>
<script lang="ts" setup>
import { Line, LineOptions } from '@antv/g2plot';

type LineData = {
  date: string,
  price: number,
  type: string
}
const props = defineProps({
  chart_data: {
    type: Object as PropType<LineData[]>,
    required: true
  }
});
const refDOM = ref();
const lineOptions: LineOptions = {
  data: props.chart_data,
  smooth: true,
  padding: 'auto',
  xField: 'date',
  yField: 'price',
  seriesField: 'type'
}
var lineDOM: Line;
onMounted(() => {
  lineDOM = new Line(refDOM.value, lineOptions);
  lineDOM.render();
});
watch(() => props.chart_data, (newValue, oldValue) => {
  oldValue
  lineDOM.changeData(toRaw(newValue));
  lineDOM.render();
});
onUnmounted(() => {
  lineDOM.destroy();
});
</script>
<style lang="less" scoped>

</style>