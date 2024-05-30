<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container" ref="refDOM" />
</template>
<script lang="ts" setup>
import { Column, ColumnOptions } from '@antv/g2plot';


const props = defineProps({
  data: {
    type: Object as PropType<Record<string, any>[]>,
    default: () => {
      return {}
    }
  },
  xLabel: {
    type: String,
    default: "date"
  },
  yLabel: {
    type: String,
    default: "value"
  }
})
const refDOM = ref()
const barOptions: ColumnOptions = {
  data: props.data,
  xField: props.xLabel,
  yField: props.yLabel,
  seriesField: "type"
}
var barDOM: Column;
onMounted(() => {
  barDOM = new Column(refDOM.value, barOptions);
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