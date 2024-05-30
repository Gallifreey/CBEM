<!-- eslint-disable vue/multi-word-component-names -->
<template>
	<PageContainer>
		<template #content>
			<a-form :model="formState"
			:label-col="{ span: 8 }"
    	:wrapper-col="{ span: 10 }"
			>
				<a-form-item name="name" label="仓库名称" :rules="[{ required: true, message: '请输入仓库名称' }]">
					<a-input v-model:value="formState.name" />
				</a-form-item>
				<a-form-item name="address" label="仓库地址"  :rules="[{ required: true, message: '请输入仓库地址' }]">
					<a-input v-model:value="formState.address"/>
				</a-form-item>
				<a-form-item :wrapper-col="{ offset: 8, span: 16 }">
					<a-button type="primary" html-type="submit">添加</a-button>
				</a-form-item>
			</a-form>
		</template>
	</PageContainer>
</template>
<script lang="ts" setup>

interface FormState {
	name: string,
	address: string
}
const formState = ref<FormState>({
	name: "",
	address: "",
})
</script>
<style lang="less" scoped>

</style>