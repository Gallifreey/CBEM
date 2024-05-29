<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div class="container">
    <a-input v-if="props.type === 'input'" class="t-input" v-model:value="valueE" :style="{width: props.width}" />
    <a-textarea v-else show-count :rows="3" :bordered="false" class="t-input" v-model:value="valueE" :style="{width: props.width}" />
  </div>
</template>
<script lang="ts" setup>

type widthType = Number | String
type inputType = "input" | "textarea"
const props = defineProps({
  value: {
    type: String,
    default: ""
  },
  width: {
    type: Object as PropType<widthType>,
    default: "200px"
  },
  type: {
    type: Object as PropType<inputType>,
    default: "input"
  }
})
const emits = defineEmits(['update:value'])
const valueE = useVModel(props, 'value', emits)
</script>
<style lang="less" scoped>
.t-input{
  box-shadow: none;
  border: none;
  font-size: 16px;
  border-radius: 0;
  border: 1px solid transparent;
  font-family: harmony;
}
.t-input:hover{
  border: 1px solid black;
}
</style>